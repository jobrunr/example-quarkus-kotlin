package org.jobrunr.examples.webapp

import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.jobrunr.examples.services.MyService
import org.jobrunr.jobs.lambdas.JobLambda
import org.jobrunr.scheduling.JobScheduler


@Path("/jobs")
class JobResource {

    @Inject
    lateinit var jobScheduler: JobScheduler

    @Inject
    lateinit var myService: MyService

    @GET
    @Path("/simple-job")
    fun simpleJob(): String {
        jobScheduler.enqueue {
            println("simple job done!")
        }

        return "example simple job scheduled - see http://localhost:8000/dashboard to monitor the job."
    }

    @GET
    @Path("/simple-job-instance")
    @Produces(MediaType.TEXT_PLAIN)
    fun simpleJobUsingInstance(@DefaultValue("Hello world") @QueryParam("value") value: String?): String {
        // This will crash in native mode (see README.md)
        val enqueuedJobId = jobScheduler.enqueue(JobLambda { myService.doSimpleJob(value) })
        return "Job Enqueued: $enqueuedJobId - see http://localhost:8000/dashboard to monitor the job."
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    fun index(): String {
        return "Hello World from /jobs JobResource!<br />" +
                "You can:<br />" +
                "- <a href=\"/jobs/simple-job\">Enqueue a simple job</a><br />" +
                "- <a href=\"/jobs/simple-job-instance\">Enqueue a simple job using a service instance</a><br />" +
                "- Learn more on <a href=\"https://www.jobrunr.io/\">www.jobrunr.io</a><br />"
    }

}