package com.dgsw.cns.global.dependency;

import com.dgsw.cns.annotations.UseCase;
import lombok.extern.log4j.Log4j2;
import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Log4j2
@Configuration
public class ConfigLoader implements BeanFactoryPostProcessor {
    private final Reflections reflections = new Reflections("com.dgsw.cns");

    private String getBeanNameOf(Class<?> clazz) {
        String original = clazz.getSimpleName();
        if(original.length() == 1) return original.toLowerCase();

        return String.format("%s%s",
                original.substring(0, 1).toLowerCase(),
                original.substring(1));
    }

    private String getQualifiedBeanName(DefaultListableBeanFactory beanFactory, Class<?> qualifiedType) {
        for(String beanName: beanFactory.getBeanDefinitionNames()) {
            if(beanFactory.isTypeMatch(beanName, qualifiedType))
                return beanName;
        }

        return null;
    }

    private void registerBean(DefaultListableBeanFactory beanRegistry, Class<?> componentClass) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(componentClass);
        Class<?>[] params = componentClass.getConstructors()[0].getParameterTypes();

        for(Class<?> beanType: params) {
            String qualifiedBeanName = getQualifiedBeanName(beanRegistry, beanType);
            if(qualifiedBeanName == null) continue;

            builder.addConstructorArgReference(qualifiedBeanName);
            builder.addDependsOn(qualifiedBeanName);
        }

        beanRegistry.registerBeanDefinition(getBeanNameOf(componentClass), builder.getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Set<Class<?>> useCaseClasses = reflections.getTypesAnnotatedWith(UseCase.class);
        DefaultListableBeanFactory beanRegistry = (DefaultListableBeanFactory) beanFactory;

        for (Class<?> componentClass : useCaseClasses)
            registerBean(beanRegistry, componentClass);

        log.info("{} Usecases have successfully registered into Spring Context", useCaseClasses.size());
    }
}
