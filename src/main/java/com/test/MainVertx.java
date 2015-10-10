package com.test;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

import java.net.HttpURLConnection;

/**
 *
 */
public class MainVertx {

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();

    // Create Webserver
    HttpServer server = vertx.createHttpServer();
    Router router = Router.router(vertx);

    router.routeWithRegex(".*").handler(routingContext -> {
      System.out.println("Handle request");
      routingContext.response().setStatusCode(HttpURLConnection.HTTP_NOT_FOUND);
      routingContext.response().end();
    });

    // Start server
    server.requestHandler(router::accept).listen(8888);
    System.out.println("Now open your browser to enter https://localhost:8888");
  }
}
