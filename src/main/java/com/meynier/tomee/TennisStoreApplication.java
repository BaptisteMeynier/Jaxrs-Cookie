package com.meynier.tomee;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationScoped
public class TennisStoreApplication extends Application {
    @Override
    public Set<Object> getSingletons() {
        return Set.of(new TennisStoreResource());
    }
}
