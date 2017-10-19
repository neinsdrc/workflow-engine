package org.radrso.workflow.internal.actions;

import org.radrso.workflow.base.Commander;
import org.radrso.workflow.internal.Operations;

/**
 * Created by rao-mengnan on 2017/5/18.
 */
public abstract class AbstractAction implements Action{
    protected Commander commander;
    protected Operations operations;

    public AbstractAction(Commander commander) {
        this.commander = commander;
        this.operations = new Operations(commander);
    }
}
