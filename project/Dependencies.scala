import sbt._
import Keys._

object Dependencies {
  val Scala212 = "2.12.10"
  val Scala213 = "2.13.1"
  val ScalaVersions = Seq(Scala212, Scala213)

  val AkkaVersion = System.getProperty("override.akka.version", "2.6.4")
  val AkkaVersionInDocs = AkkaVersion.take(3)
  val CassandraVersionInDocs = "4.0"
  val DriverVersionInDocs = "4.5"

  val AlpakkaVersion = "2.0.1"
  val AlpakkaVersionInDocs = AlpakkaVersion.take(3)
  // for example
  val AkkaManagementVersion = "1.0.6"

  val Logback = "ch.qos.logback" % "logback-classic" % "1.2.3"

  val silencerVersion = "1.5.0"
  val silencer = Seq(
    compilerPlugin(("com.github.ghik" %% "silencer-plugin" % silencerVersion).cross(CrossVersion.patch)),
    ("com.github.ghik" %% "silencer-lib" % silencerVersion % Provided).cross(CrossVersion.patch))

  val reconcilerDependencies = Seq(
    "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
    "com.typesafe.akka" %% "akka-stream-testkit" % AkkaVersion % Test)

  val akkaTestDeps = Seq(
    "com.typesafe.akka" %% "akka-persistence",
    "com.typesafe.akka" %% "akka-persistence-typed",
    "com.typesafe.akka" %% "akka-persistence-query",
    "com.typesafe.akka" %% "akka-cluster-typed",
    "com.typesafe.akka" %% "akka-actor-testkit-typed",
    "com.typesafe.akka" %% "akka-persistence-tck",
    "com.typesafe.akka" %% "akka-stream-testkit",
    "com.typesafe.akka" %% "akka-multi-node-testkit",
    "com.typesafe.akka" %% "akka-cluster-sharding")

  val akkaPersistenceCassandraDependencies = Seq(
      "com.lightbend.akka" %% "akka-stream-alpakka-cassandra" % AlpakkaVersion,
      "com.typesafe.akka" %% "akka-persistence" % AkkaVersion,
      "com.typesafe.akka" %% "akka-persistence-query" % AkkaVersion,
      "com.typesafe.akka" %% "akka-cluster-tools" % AkkaVersion,
      Logback % Test,
      "org.scalatest" %% "scalatest" % "3.1.0" % Test,
      "org.pegdown" % "pegdown" % "1.6.0" % Test,
      "org.osgi" % "org.osgi.core" % "5.0.0" % Provided) ++ akkaTestDeps.map(_ % AkkaVersion % Test)

  val exampleDependencies = Seq(
    Logback,
    "com.typesafe.akka" %% "akka-persistence-typed" % AkkaVersion,
    "com.typesafe.akka" %% "akka-discovery" % AkkaVersion,
    "com.typesafe.akka" %% "akka-serialization-jackson" % AkkaVersion,
    "com.typesafe.akka" %% "akka-cluster-sharding-typed" % AkkaVersion,
    "com.lightbend.akka.management" %% "akka-management" % AkkaManagementVersion,
    "com.lightbend.akka.management" %% "akka-management-cluster-bootstrap" % AkkaManagementVersion,
    "com.lightbend.akka.management" %% "akka-management-cluster-http" % AkkaManagementVersion,
    "com.lightbend.akka.discovery" %% "akka-discovery-kubernetes-api" % AkkaManagementVersion,
    "org.hdrhistogram" % "HdrHistogram" % "2.1.12")

  val dseTestDependencies = Seq(
    "com.datastax.dse" % "dse-java-driver-core" % "2.3.0" % Test,
    "com.typesafe.akka" %% "akka-persistence-tck" % AkkaVersion % Test,
    "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
    "com.typesafe.akka" %% "akka-stream-testkit" % AkkaVersion % Test,
    Logback % Test)
}
