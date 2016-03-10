package hello.auditing;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class jpaAuditingHandlerRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        registry.registerBeanDefinition("jpaAuditingHandler", BeanDefinitionBuilder
                .rootBeanDefinition(JpaAuditingHandler.class)
                .addConstructorArgReference("jpaMappingContext")
                .getBeanDefinition());
    }
}
