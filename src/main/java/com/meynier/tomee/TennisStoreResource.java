package com.meynier.tomee;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.Executor;

@Path("/store")
public class TennisStoreResource {

    @Inject
    private Executor executor;

    private static final List<String> raquetteBrand = List.of("Head", "Wilson", "Babolat");

    @GET
    public void asyncGet(@Suspended final AsyncResponse asyncResponse) {
        executor.execute(() -> asyncResponse.resume(raquetteBrand));
    }

    @GET
    @Path("cookie")
    public Response createCookies() {
        NewCookie cookie1 = new NewCookie("myStrCookie", "cookieStrVal");
        NewCookie cookie2 = new NewCookie("myDateCookie", "2017-03-28");
        NewCookie cookie3 = new NewCookie("myIntCookie", "100");
        return Response
                .ok("myStrCookie, myDateCookie and myIntCookie sent to the browser")
                .cookie(cookie1, cookie2, cookie3)
                .build();
    }
}
