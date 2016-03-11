package com.gamarlos.melapelapps.service
/**
 */
class ConsumerManagerImpl /*implements ConsumerManager */{
/*

    ConsumerRepository repository

    ConsumerManagerImpl(ConsumerRepository repository){
        this.repository = repository
    }

    @Override
    @Cacheable("consumers")
    Consumer getConsumer(String id) {
        Consumer consumer = findConsumer(id)
        if(consumer == null){
            throw new ResourceNotFoundExeption("Consumer ${id} does not exist")
        }
        return consumer
    }

    private Consumer findConsumer(String id){
        repository.getConsumer(id)
    }

    @Override
    @CacheEvict(value=["consumers","consumerClients"], allEntries = true)
    void saveConsumer(String id, String provider, String url) {
        if(id == null || url == null){
            throw new IllegalArgumentException("id (${id}) and url (${url}) are required fields")
        }
        Consumer consumer = findConsumer(id)

        if(consumer == null || consumer.provider == provider) {
            repository.saveConsumer(id, provider, url)
        }else{
            throw new AccessControlException("Consumer with this id (${id}) already exists")
        }
    }

    @Override
    @Cacheable("consumerClients")
    NotificationClient getClient(String id){
        Consumer c = findConsumer(id)
        if( c != null ){
            return Feign.builder().encoder(new GsonEncoder()).decoder(new GsonDecoder()).target(NotificationClient, c.url )
        }
        return null
    }
    */
}
