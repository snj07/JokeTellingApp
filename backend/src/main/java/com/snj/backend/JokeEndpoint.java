package com.snj.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.snj.jokeslib.JokeCracker;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "libjoke",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.snj.com",
                ownerName = "backend.snj.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "getJoke")
    public Joke getJoke() {
        return new Joke(new JokeCracker().getJoke());
    }

}
