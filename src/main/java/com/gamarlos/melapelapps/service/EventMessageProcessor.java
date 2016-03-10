package com.gamarlos.melapelapps.service;

/**
 * Created by mcamacho on 9/10/15.
 */
public class EventMessageProcessor {
/*
    private Logger log = LoggerFactory.getLogger(EventMessageProcessor.class);

    private  static List<String> processingStatus = asList("Initializing", "Start Ringing", "Answered", "Terminated", "Disconnected");

    SubscriptionRepository subscriptionRepository;
    ConsumerManager consumerManager;
    NotificationCommand command;
    Long messageExpirationMs;

    protected EventMessageProcessor(SubscriptionRepository subscriptionService, ConsumerManager consumerManager, NotificationCommand command) {
        this(subscriptionService, consumerManager, command, 10000L);
    }

    public EventMessageProcessor(SubscriptionRepository subscriptionService, ConsumerManager consumerManager, NotificationCommand command, Long messageExpirationMs) {
        this.subscriptionRepository = subscriptionService;
        this.consumerManager = consumerManager;
        this.command = command;
        this.messageExpirationMs = messageExpirationMs;
    }

    @Override
    public void process(Object message) {
        log.debug("Processing event: {}", message);

        EventMessage eventMessage = (EventMessage) message;
        Subscription subscription = subscriptionRepository.getSubscription(eventMessage.username());

        if (subscription == null) {
            log.debug("Subscription not found: {}", eventMessage.username());
            return;
        }
        if(messageExpirationMs != null){
            if(eventMessage.isExpired(messageExpirationMs)){
                log.warn("Message is expired, ignoring: {}", eventMessage.toString());
                return;
            }
        }

        if ( processingStatus.stream().anyMatch(i -> i.equals(eventMessage.event())) ) {
            subscription.getConsumers().stream().forEach(
                    consumer -> {
                        try {
                            String consumerName = consumer.getName();
                            NotificationClient client = consumerManager.getClient(consumerName);

                            if (client != null) {
                                log.info("calling doRequest: consumer={}, username={}", consumerName, eventMessage.username());
                                eventMessage.setConsumer(consumerName);
                                command.doRequest(client, consumer.getCallback(), eventMessage);
                            } else {
                                log.warn("invalid consumer: {}", consumerName);
                            }
                        }catch(Throwable t){
                            //squash
                            log.error("Error firing callback: "+consumer.getName());
                        }
                    }
            );
        }
    }
*/
}
