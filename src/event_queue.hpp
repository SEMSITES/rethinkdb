
#ifndef __EVENT_QUEUE_HPP__
#define __EVENT_QUEUE_HPP__

#include <pthread.h>
#include <libaio.h>
#include "memalign_alloc.hpp"
#include "pool_alloc.hpp"
#include "objectheap_alloc.hpp"
#include "dynamic_pool_alloc.hpp"
#include "alloc_stats.hpp"

// Event handling
typedef int resource_t;
enum event_type_t {
    et_disk_event, et_sock_event, et_timer_event
};
enum event_op_t {
    eo_read, eo_write
};
struct event_t {
    event_type_t event_type;
    resource_t source;
    event_op_t op;

    // State associated with the communication (must have been passed
    // to queue_watch_resource).
    void *state;

    /* For event_type == et_disk_event, contains the result of the IO
     * operation. For event_type == et_timer_event, contains the
     * number of experiations of the timer that have occurred. */
    int result;

    /* For event_type == et_disk_event */
    void *buf;    // Location of the buffer where data was copied (for read events)
};
struct event_queue_t;
typedef void (*event_handler_t)(event_queue_t*, event_t*);

// Helper structure for blocks of 512 bytes.
// TODO: get rid of this when we have a full memory caching
// architecture.
template<int N>
struct buffer_t {
    char _buf[N];
};

// Event queue structure
struct worker_pool_t;
struct event_queue_t {
    int queue_id;
    io_context_t aio_context;
    int aio_notify_fd;
    int timer_fd;
    long total_expirations;
    pthread_t epoll_thread;
    int epoll_fd;
    event_handler_t event_handler;
    // TODO: add a checking allocator (check if malloc returns NULL)
    typedef objectheap_alloc_t<
        dynamic_pool_alloc_t<alloc_stats_t<pool_alloc_t<memalign_alloc_t<> > > >,
        iocb, buffer_t<512> > small_obj_alloc_t;
    small_obj_alloc_t alloc;
    worker_pool_t *parent_pool;
    volatile bool dying;
};

// Event queue initialization/destruction
void create_event_queue(event_queue_t *event_queue, int queue_id, event_handler_t event_handler,
                        worker_pool_t *parent_pool);
void destroy_event_queue(event_queue_t *event_queue);

void queue_watch_resource(event_queue_t *event_queue, resource_t resource,
                          event_op_t event_op, void *state);
void queue_forget_resource(event_queue_t *event_queue, resource_t resource);

#endif // __EVENT_QUEUE_HPP__

