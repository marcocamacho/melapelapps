package com.gamarlos.melapelapps.domain;

/**
 * Created by mcamacho on 9/4/15.
 */
public class LocalParty {
    String username;
    String extension;
    Integer deviceKitId;
    String name;

    @Override
    public String toString() {
        return "LocalParty{" +
                "username='" + username + '\'' +
                ", extension='" + extension + '\'' +
                ", deviceKitId=" + deviceKitId +
                ", name='" + name + '\'' +
                '}';
    }
}
