package org.jboss.resteasy.test.rx.rxjava2.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.Stream;
import org.jboss.resteasy.test.rx.resource.TRACE;
import org.jboss.resteasy.test.rx.resource.Thing;

import io.reactivex.Flowable;

public interface Rx2FlowableResource {

   @GET
   @Path("get/string")
   @Produces(MediaType.TEXT_PLAIN)
   @Stream
   public Flowable<String> get();

   @GET
   @Path("get/thing")
   @Produces(MediaType.APPLICATION_JSON)
   @Stream
   public Flowable<Thing> getThing();

   @GET
   @Path("get/thing/list")
   @Produces(MediaType.APPLICATION_JSON)
   @Stream
   public Flowable<List<Thing>> getThingList();

   @GET
   @Path("get/bytes")
   @Produces(MediaType.APPLICATION_OCTET_STREAM)
   @Stream
   public Flowable<byte[]> getBytes();

   @PUT
   @Path("put/string")
   @Consumes(MediaType.TEXT_PLAIN)
   @Produces(MediaType.TEXT_PLAIN)
   @Stream
   public Flowable<String> put(String s);

   @PUT
   @Path("put/thing")
   @Consumes(MediaType.TEXT_PLAIN)
   @Produces(MediaType.APPLICATION_JSON)
   @Stream
   public Flowable<Thing> putThing(String s);

   @PUT
   @Path("put/thing/list")
   @Consumes(MediaType.TEXT_PLAIN)
   @Produces(MediaType.APPLICATION_JSON)
   @Stream
   public Flowable<List<Thing>> putThingList(String s);

   @PUT
   @Path("put/bytes")
   @Consumes(MediaType.TEXT_PLAIN)
   @Produces(MediaType.APPLICATION_OCTET_STREAM)
   @Stream
   public Flowable<byte[]> putBytes(String s);

   @POST
   @Path("post/string")
   @Produces(MediaType.TEXT_PLAIN)
   @Consumes(MediaType.TEXT_PLAIN)
   @Stream
   public Flowable<String> post(String s);

   @POST
   @Path("post/thing")
   @Consumes(MediaType.TEXT_PLAIN)
   @Produces(MediaType.APPLICATION_JSON)
   @Stream
   public Flowable<Thing> postThing(String s);

   @POST
   @Path("post/thing/list")
   @Consumes(MediaType.TEXT_PLAIN)
   @Produces(MediaType.APPLICATION_JSON)
   @Stream
   public Flowable<List<Thing>> postThingList(String s);

   @POST
   @Path("post/bytes")
   @Consumes(MediaType.TEXT_PLAIN)
   @Produces(MediaType.APPLICATION_OCTET_STREAM)
   @Stream
   public Flowable<byte[]> postBytes(String s);

   @DELETE
   @Path("delete/string")
   @Produces(MediaType.TEXT_PLAIN)
   @Stream
   public Flowable<String> delete();

   @DELETE
   @Path("delete/thing")
   @Produces(MediaType.APPLICATION_JSON)
   @Stream
   public Flowable<Thing> deleteThing();

   @DELETE
   @Path("delete/thing/list")
   @Produces(MediaType.APPLICATION_JSON)
   @Stream
   public Flowable<List<Thing>> deleteThingList();

   @DELETE
   @Path("delete/bytes")
   @Produces(MediaType.APPLICATION_OCTET_STREAM)
   @Stream
   public Flowable<byte[]> deleteBytes();

   @HEAD
   @Path("head/string")
   @Produces(MediaType.TEXT_PLAIN)
   @Stream
   public Flowable<String> head();

   @OPTIONS
   @Path("options/string")
   @Produces(MediaType.TEXT_PLAIN)
   @Stream
   public Flowable<String> options();

   @OPTIONS
   @Path("options/thing")
   @Produces(MediaType.APPLICATION_JSON)
   @Stream
   public Flowable<Thing> optionsThing();

   @OPTIONS
   @Path("options/thing/list")
   @Produces(MediaType.APPLICATION_JSON)
   @Stream
   public Flowable<List<Thing>> optionsThingList();

   @OPTIONS
   @Path("options/bytes")
   @Produces(MediaType.APPLICATION_OCTET_STREAM)
   @Stream
   public Flowable<byte[]> optionsBytes();

   @TRACE
   @Path("trace/string")
   @Produces(MediaType.TEXT_PLAIN)
   @Stream
   public Flowable<String> trace();

   @TRACE
   @Path("trace/thing")
   @Produces(MediaType.APPLICATION_JSON)
   @Stream
   public Flowable<Thing> traceThing();

   @TRACE
   @Path("trace/thing/list")
   @Produces(MediaType.APPLICATION_JSON)
   @Stream
   public Flowable<List<Thing>> traceThingList();

   @TRACE
   @Path("trace/bytes")
   @Produces(MediaType.APPLICATION_OCTET_STREAM)
   @Stream
   public Flowable<byte[]> traceBytes();

   @GET
   @Path("exception/unhandled")
   public Flowable<Thing> exceptionUnhandled() throws Exception;

   @GET
   @Path("exception/handled")
   public Flowable<Thing> exceptionHandled() throws Exception;
}
