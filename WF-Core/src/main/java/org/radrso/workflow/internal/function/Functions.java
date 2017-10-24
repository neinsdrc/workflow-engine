package org.radrso.workflow.internal.function;

import org.radrso.workflow.function.Consumer;
import org.radrso.workflow.internal.model.Next;
import org.radrso.workflow.internal.model.WorkflowInstanceInfo;
import org.radrso.workflow.entities.schema.items.Transfer;
import org.radrso.workflow.function.Condition;
import org.radrso.workflow.function.ConversionParam1;
import org.radrso.workflow.function.ConversionParam2;
import org.radrso.workflow.handler.CompareHandler;
import org.radrso.workflow.handler.SchemaParamHandler;
import org.radrso.workflow.schedulers.TaskScheduler;

import java.util.List;
import java.util.Map;

/**
 * Created by Rao-Mengnan
 * on 2017/10/23.
 */
public class Functions {
    public static Condition<Object, Object, Boolean> condition(String condition) {
        CompareHandler handler = new CompareHandler(condition);
        return new Condition<Object, Object, Boolean>() {
            @Override
            public Boolean check(Object o, Object o2) throws Exception {
                return handler.compare(o, o2);
            }
        };
    }

    public static ConversionParam1<Transfer, List<Map<String, Object>>> mapParam1(WorkflowInstanceInfo instance) {
        SchemaParamHandler handler = new SchemaParamHandler(instance);
        return new ConversionParam1<Transfer, List<Map<String, Object>>>() {
            @Override
            public List<Map<String, Object>> mapTo(Transfer transfer) throws Exception {
                return handler.parameters(transfer);
            }
        };
    }

    public static ConversionParam2<String, String, Object> mapParam2(WorkflowInstanceInfo instance) {
        SchemaParamHandler handler = new SchemaParamHandler(instance);
        return new ConversionParam2<String, String, Object>() {
            @Override
            public Object mapTo(String param, String type) throws Exception {
                return handler.convertStrParam(param, type);
            }
        };
    }

    public static Consumer<List<Next>> submitNext() {
        return new Consumer<List<Next>>() {
            @Override
            public void accept(List<Next> nextList) throws Exception {
                TaskScheduler.submit(nextList);
            }
        };
    }
}
