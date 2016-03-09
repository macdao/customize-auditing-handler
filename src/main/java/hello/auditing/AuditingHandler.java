package hello.auditing;

import hello.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.mapping.PersistentProperty;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mapping.context.PersistentEntities;

import java.util.Collections;

public class AuditingHandler extends org.springframework.data.auditing.AuditingHandler {
    @Autowired
    private Application application;

    public AuditingHandler(MappingContext<? extends PersistentEntity<?, ?>, ? extends PersistentProperty<?>> mappingContext) {
        super(new PersistentEntities(Collections.singletonList(mappingContext)));
    }

    @Override
    public void markCreated(Object source) {
        System.out.println("markCreated");
        System.out.println(application);
    }

    @Override
    public void markModified(Object source) {
        System.out.println("markModified");
        System.out.println(application);
    }


}
