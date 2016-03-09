package hello.auditing;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.data.auditing.config.AuditingConfiguration;
import org.springframework.data.jpa.repository.config.PublicJpaAuditingRegistrar;

import java.lang.annotation.Annotation;

public class JpaAuditingRegistrar extends PublicJpaAuditingRegistrar {
    @Override
    protected Class<? extends Annotation> getAnnotation() {
        return EnableJpaAuditing.class;
    }

    @Override
    protected BeanDefinitionBuilder getAuditHandlerBeanDefinitionBuilder(AuditingConfiguration configuration) {
        return BeanDefinitionBuilder
                .rootBeanDefinition(AuditingHandler.class)
                .setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE)
                .addConstructorArgReference(JPA_MAPPING_CONTEXT_BEAN_NAME);
    }
}
