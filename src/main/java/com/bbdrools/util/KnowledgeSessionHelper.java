/**
 * 
 */
package com.bbdrools.util;

import org.kie.api.KieServices;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ayazpasha
 *
 */
@Slf4j
public class KnowledgeSessionHelper {
	
	/**
	 * 
	 */
	private KnowledgeSessionHelper() {}
	
	public static KieContainer createRuleBase() {
		KieServices ks = KieServices.Factory.get();
		return ks.getKieClasspathContainer();
	}
	
	public static StatelessKieSession getStatelessKnowledgeSession(KieContainer kieContainer, String sessionName) {
		return kieContainer.newStatelessKieSession(sessionName);
	}
	
	public static KieSession getStatefulKnowledgeSession(KieContainer kieContainer, String sessionName) {
		return kieContainer.newKieSession(sessionName);
	}
	
	public static KieSession getStatefulKnowledgeSessionWithCallback(
            KieContainer kieContainer, String sessionName) {
		
        KieSession session = getStatefulKnowledgeSession(kieContainer, sessionName);
        session.addEventListener(new RuleRuntimeEventListener() {
            public void objectInserted(ObjectInsertedEvent event) {
                log.debug("Object inserted \n"
                        + event.getObject().toString());
            }
            public void objectUpdated(ObjectUpdatedEvent event) {
            	log.debug("Object was updated \n"
                        + "new Content \n" + event.getObject().toString());
            }
            public void objectDeleted(ObjectDeletedEvent event) {
            	log.debug("Object retracted \n"
                        + event.getOldObject().toString());
            }
        });
        
        session.addEventListener(new AgendaEventListener() {
            public void matchCreated(MatchCreatedEvent event) {
            	log.debug("The rule "
                        + event.getMatch().getRule().getName()
                        + " can be fired in agenda");
            }
            public void matchCancelled(MatchCancelledEvent event) {
            	log.debug("The rule "
                        + event.getMatch().getRule().getName()
                        + " cannot be in agenda");
            }
            public void beforeMatchFired(BeforeMatchFiredEvent event) {
            	log.debug("The rule "
                        + event.getMatch().getRule().getName()
                        + " will be fired");
            }
            public void afterMatchFired(AfterMatchFiredEvent event) {
            	log.debug("The rule "
                        + event.getMatch().getRule().getName()
                        + " has been fired");
            }
            public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
            	
            	/**
            	 * Will be implemented if required
            	 */
            }
            public void agendaGroupPushed(AgendaGroupPushedEvent event) {
            	
            	/**
            	 * Will be implemented if required
            	 */
            }
            public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
            	
            	/**
            	 * Will be implemented if required
            	 */
            }
            public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
            	
            	/**
            	 * Will be implemented if required
            	 */
            }
            public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
            	
            	/**
            	 * Will be implemented if required
            	 */
            }
            public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
            	
            	/**
            	 * Will be implemented if required
            	 */
            }
        });
        
        return session;
	}

}
