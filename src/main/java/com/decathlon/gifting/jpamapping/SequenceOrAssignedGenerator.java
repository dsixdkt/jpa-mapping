package com.decathlon.gifting.jpamapping;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.AnnotationBasedGenerator;
import org.hibernate.generator.EventType;
import org.hibernate.generator.GeneratorCreationContext;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.lang.reflect.Member;
import java.util.EnumSet;
import java.util.Properties;

public class SequenceOrAssignedGenerator extends SequenceStyleGenerator implements AnnotationBasedGenerator<SequenceOrAssigned> {
	private String sequenceName;
	private int allocationSize;

	@Override
	public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) throws MappingException {
		parameters.setProperty("increment_size", String.valueOf(allocationSize));
		parameters.setProperty("sequence_name", sequenceName);
		super.configure(type, parameters, serviceRegistry);
	}

	@Override
	public Object generate(SharedSessionContractImplementor session, Object owner) throws HibernateException {
		final Long id = owner instanceof Identifiable myEntity ? myEntity.getId() : null;
		return id == null ? super.generate(session, owner) : id;
	}

	@Override
	public EnumSet<EventType> getEventTypes() {
		return super.getEventTypes();
	}

	@Override
	public boolean allowAssignedIdentifiers() {
		return true;
	}

	@Override
	public Object generate(SharedSessionContractImplementor session, Object owner, Object currentValue, EventType eventType) {
		final Long id = owner instanceof Identifiable myEntity ? myEntity.getId() : null;
		return id == null ? super.generate(session, owner, currentValue, eventType) : id;
	}

	@Override
	public void initialize(SequenceOrAssigned annotation, Member member, GeneratorCreationContext context) {
		sequenceName = annotation.sequenceName();
		allocationSize = annotation.allocationSize();
	}
}