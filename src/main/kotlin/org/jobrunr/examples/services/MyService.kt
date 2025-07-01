package org.jobrunr.examples.services

import io.quarkus.runtime.annotations.RegisterForReflection
import jakarta.enterprise.context.ApplicationScoped
import org.jobrunr.jobs.annotations.Job
import org.jobrunr.jobs.annotations.Recurring

@ApplicationScoped
@RegisterForReflection
class MyService {

    @Recurring(id = "my-recurring-job", cron = "*/2 * * * *")
    @Job(name = "Doing some recurring work every 2min")
    fun aRecurringJob() {
        println("Doing some work recurrently.")
    }

    fun doSimpleJob(anArgument: String?) {
        println("Doing some work: $anArgument")
    }
}