// Autogenerated by metajava.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../../../../templates/AstSubclass.java
package com.rethinkdb.ast.gen;

import com.rethinkdb.model.Arguments;
import com.rethinkdb.model.OptArgs;
import com.rethinkdb.ast.ReqlAst;
import com.rethinkdb.proto.TermType;


public class Table extends ReqlQuery {


    public Table(java.lang.Object arg) {
        this(new Arguments(arg), null);
    }
    public Table(Arguments args, OptArgs optargs) {
        this(null, args, optargs);
    }
    public Table(ReqlAst prev, Arguments args, OptArgs optargs) {
        this(prev, TermType.TABLE, args, optargs);
    }
    protected Table(ReqlAst previous, TermType termType, Arguments args, OptArgs optargs){
        super(previous, termType, args, optargs);
    }


    /* Static factories */
    public static Table fromArgs(java.lang.Object... args){
        return new Table(new Arguments(args), null);
    }


    public Get get(java.lang.Object... fields) {
        return new Get(this, new Arguments(fields), new OptArgs());
    }

    public GetAll getAll(java.lang.Object... fields) {
        return new GetAll(this, new Arguments(fields), new OptArgs());
    }

    public Insert insert(java.lang.Object... fields) {
        return new Insert(this, new Arguments(fields), new OptArgs());
    }

    public Config config(java.lang.Object... fields) {
        return new Config(this, new Arguments(fields), new OptArgs());
    }

    public Status status(java.lang.Object... fields) {
        return new Status(this, new Arguments(fields), new OptArgs());
    }

    public Wait wait(java.lang.Object... fields) {
        return new Wait(this, new Arguments(fields), new OptArgs());
    }

    public Reconfigure reconfigure(java.lang.Object... fields) {
        return new Reconfigure(this, new Arguments(fields), new OptArgs());
    }

    public Rebalance rebalance(java.lang.Object... fields) {
        return new Rebalance(this, new Arguments(fields), new OptArgs());
    }

    public Sync sync(java.lang.Object... fields) {
        return new Sync(this, new Arguments(fields), new OptArgs());
    }

    public IndexCreate indexCreate(java.lang.Object... fields) {
        return new IndexCreate(this, new Arguments(fields), new OptArgs());
    }

    public IndexDrop indexDrop(java.lang.Object... fields) {
        return new IndexDrop(this, new Arguments(fields), new OptArgs());
    }

    public IndexList indexList(java.lang.Object... fields) {
        return new IndexList(this, new Arguments(fields), new OptArgs());
    }

    public IndexStatus indexStatus(java.lang.Object... fields) {
        return new IndexStatus(this, new Arguments(fields), new OptArgs());
    }

    public IndexWait indexWait(java.lang.Object... fields) {
        return new IndexWait(this, new Arguments(fields), new OptArgs());
    }

    public IndexRename indexRename(java.lang.Object... fields) {
        return new IndexRename(this, new Arguments(fields), new OptArgs());
    }

    public GetIntersecting getIntersecting(java.lang.Object... fields) {
        return new GetIntersecting(this, new Arguments(fields), new OptArgs());
    }

    public GetNearest getNearest(java.lang.Object... fields) {
        return new GetNearest(this, new Arguments(fields), new OptArgs());
    }

}