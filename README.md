# Google Cloud Logging
This plugin will log job build information for Jenkins jobs to either BigQuery or Datastore. 
A modification of this https://github.com/homedepot/GoogleCloudLoggingPlugin to enable a variable to be set to turn on a job
An extra field in the BigQuery database for the channel associated with the tests as well.

## Setup
1. Install Google Cloud Logging via Upload Plugin in Jenkins Plugin Manager.
2. Setup your application default credentials on your Jenkins box. Refer to [Google's Documentation](https://developers.google.com/identity/protocols/application-default-credentials) for more information and help doing this.
3. In Manage Jenkins -> Configure System -> Google Cloud Logging:
 - BigQuery: Enable BigQuery Logging and set the Project, Dataset, and Table you want Jenkins to write out to. The default Google credentials on the Jenkins server will be used to write to BigQuery.
 - Datastore: Enable Datastore Logging. The default project and Google credentials on your Jenkins box will be used to log out to the kind JenkinsBuild within Datastore. The kind cannot be changed since it is tied to the class name within the entity.
4.	Within the Jenkins project create a Boolean parameter called BIG_QUERY. Set the default value to true for the plugin to send the data to BigQuery
5.	Within Jenkins Under `Build Timestamp` set the following
		Name :				BUILD_TIMESTAMP_TS
		Pattern :			yyyy-MM-dd HH:mm:ss z
		Shift timestamp:	+ 0 days 0 hours 0 minutes

### Table Structure for BigQuery

| Column Name        | Datatype    | Nullable  | Note |
| ------------- |-------------| -----| ----|
| build_tag	| STRING	| NULLABLE ||	
| job_name	| STRING	| NULLABLE ||
| build_number	| STRING	| NULLABLE ||
| build_start_ts	| TIMESTAMP	| NULLABLE ||	
| build_end_ts	| TIMESTAMP	| NULLABLE ||	
| build_duration	| INTEGER	| NULLABLE |In seconds|
| build_result	| STRING	| NULLABLE ||	
| build_url	| STRING	| NULLABLE ||	
| jenkins_url	| STRING	| NULLABLE ||
| executor_number	| STRING	| NULLABLE ||
| workspace	| STRING	| NULLABLE ||	
| params	| STRING	| NULLABLE |Key, value pairs delimited by an ampersand|
| git_commit	| STRING	| NULLABLE ||
| git_url	| STRING	| NULLABLE ||	
| git_branch	| STRING	| NULLABLE ||
| upstream_url	| STRING	| NULLABLE ||
| upstream_build_number		| STRING	| NULLABLE ||
| upstream_project	| STRING	| NULLABLE ||
| pipeline	| BOOLEAN	| NULLABLE ||
| environment	| STRING	| NULLABLE	||

### Table Structure for Datastore
| Column Name| Note |
| --- |---|
| buildDuration	|In seconds|
| buildEndTimestamp	||
| buildNumber	||
| buildResult	||
| buildStartTimestamp ||
| buildTag ||
| buildUrl	||
| executorNumber	||
| gitBranch	||
| gitCommit	||
| gitUrl	||
| jenkinsUrl	||
| jobName	||
| params	|Key, value pairs delimited by an ampersand|
| pipeline	||
| upstreamBuildNumber||
| upstreamProject	||
| upstreamUrl	||
| workspace	||

## Building
To rebuild the project locally:

```bash
brew install maven
```
Add maven path to bash profile
```bash
mvn clean package
```
# JenkinsGoogleBigQuery
