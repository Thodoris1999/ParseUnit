package com.ttyrovou.utils.parse;

public class ParseUnit<T, U> {

    private ParseUnit<?, T> parent;
    private U result;
    private boolean optional, root;

    // Constructor for root elements
    public ParseUnit(U source) {
        this.result = source;
        this.optional = false;
        this.root = true;
    }

    //constructor for children
    public ParseUnit(ParseUnit<?, T> parent, Parser<T, U> parser) {
        this.parent = parent;
        this.root = false;
        this.optional = false;
        parse(parser);
    }

    //constructor for children
    public ParseUnit(ParseUnit<?, T> parent, Parser<T, U> parser, boolean optional) {
        this.parent = parent;
        this.root = false;
        this.optional = optional;
        parse(parser);
    }

    // sets a result
    private void parse(Parser<T, U> parser) {
        if (parent.get() == null) {
            // parent was optional
            if (!optional) throw new ParseException(parent);
        } else {
            try {
                this.result = parser.parse(parent.get());
            } catch (Exception e) {
                if (!optional) throw new ParseException(e, parent);
            }
        }
    }

    public U get() {
        return result;
    }

    public ParseUnit<?, T> getParent() {
        return parent;
    }

    public boolean isRoot() {
        return root;
    }
}
