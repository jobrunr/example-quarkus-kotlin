# JobRunr Quarkus + Kotlin(x) example

This repository shows an example how you can integrate JobRunr, [Quarkus](https://quarkus.io/), and [Kotlin JSON Serialization](https://kotlinlang.org/docs/serialization.html).

If you are looking for an example on how to integrate JobRunr into a Java Quarkus project, 
please take a look at our pure Java example project: https://github.com/jobrunr/example-quarkus/. 

## About this project

This project shows how to let Quarkus + Kotlin + JobRunr play along nicely. 

> For more information on how JobRunr integrates with Quarkus, please see our **extension documentation** located at https://www.jobrunr.io/en/documentation/configuration/quarkus/.

The `build.gradle` file listing the dependencies is the most important one to inspect here, that lists the following groups of dependencies:

1. **Quarkus core** dependencies: your usual, including `smallrye-health` for monitoring as a requirement for the JobRunr Quarkus extension.
2. **Kotlin + kotlinx-serialization** dependencies.
3. **DataSources**: H2 and Quarkus's Agroal that creates a `dataSource` bean needed for JobRunr.
4. **JobRunr** core + Kotlin compatibility + Quarkus compatibility.

⚠️ Make sure NOT to include RESTEasy or any of the other JSON serializers such as Jackson as they clash with our current combination of dependencies. 

If you're unsure on which versions of `kotlinx-serialization-json` and Kotlin to pick, see our serialization support announcement at https://www.jobrunr.io/en/guides/migration/v8/#kotlin-serialisation-support.
Only JobRunr v8 and up support Kotlin serialization. 

## How to run this project

1. clone the project
2. Run the `quarkusDev` Gradle task or let your favourite IDE do the heavy lifting for you
3. Open your favorite browser:
    - Navigate to the JobRunr dashboard located at http://localhost:8000/dashboard.
    - To enqueue a simple job, open a new tab and go to http://localhost:8080/jobs/ and take it for there.
    - Visit the dashboard again and see the jobs being processed!

### Compiling it natively

For information on how to compile Quarkus + JobRunr using GraalVM, see our pure Java example project example at https://github.com/jobrunr/example-quarkus/.
