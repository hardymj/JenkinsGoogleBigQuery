/*
Copyright 2017 The Home Depot

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.jenkinsci.plugins.googlecloudlogging.entities;

import com.jmethods.catatumbo.Entity;
import com.jmethods.catatumbo.Identifier;
import com.jmethods.catatumbo.Property;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Entity
public class JenkinsBuild {
    @Identifier(autoGenerated=false)
    private String id;

    private String buildTag;
    private String jobName;
    private String buildNumber;
    private Date buildStartTimestamp;
    private Date buildEndTimestamp;
    private Long buildDuration;
    private String buildResult;
    @Property(indexed = false)
    private String buildUrl;
    @Property(indexed = false)
    private String jenkinsUrl;
    @Property(indexed = false)
    private String executorNumber;
    @Property(indexed = false)
    private String workspace;
    @Property(indexed = false)
    private String params;
    @Property(indexed = false)
    private String gitCommit;
    @Property(indexed = false)
    private String gitUrl;
    @Property(indexed = false)
    private String gitBranch;
    private String upstreamUrl;
    private String upstreamBuildNumber;
    private String upstreamProject;
    private boolean pipeline = false;
    private String environment;

	public JenkinsBuild() {}

    public JenkinsBuild(String buildTag, String jobName, String buildNumber, Date buildStartTimestamp, Date buildEndTimestamp, String buildResult, String buildUrl, String jenkinsUrl, String executorNumber, String workspace, String params, String gitCommit, String gitUrl, String gitBranch, String upstreamUrl, String upstreamBuildNumber, String upstreamProject, boolean pipeline, String environment) {
        this.id = jobName + "-" + buildNumber;
        this.buildTag = buildTag;
        this.jobName = jobName;
        this.buildNumber = buildNumber;
        this.buildStartTimestamp = buildStartTimestamp;
        this.buildEndTimestamp = buildEndTimestamp;
        long diffInMillies = buildEndTimestamp.getTime() - buildStartTimestamp.getTime();
        this.buildDuration = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        this.buildResult = buildResult;
        this.jenkinsUrl = jenkinsUrl;
        this.buildUrl = buildUrl;
        this.executorNumber = executorNumber;
        this.workspace = workspace;
        this.params = params;
        this.gitCommit = gitCommit;
        this.gitUrl = gitUrl;
        this.gitBranch = gitBranch;
        this.upstreamUrl = upstreamUrl;
        this.upstreamBuildNumber = upstreamBuildNumber;
        this.upstreamProject = upstreamProject;
        this.pipeline = pipeline;
        this.environment = environment;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuildTag() {
        return buildTag;
    }

    public void setBuildTag(String buildTag) {
        this.buildTag = buildTag;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public Date getBuildStartTimestamp() {
        return buildStartTimestamp;
    }

    public void setBuildStartTimestamp(Date buildStartTimestamp) {
        this.buildStartTimestamp = buildStartTimestamp;
    }

    public Date getBuildEndTimestamp() {
        return buildEndTimestamp;
    }

    public void setBuildEndTimestamp(Date buildEndTimestamp) {
        this.buildEndTimestamp = buildEndTimestamp;
    }

    public Long getBuildDuration() {
        return buildDuration;
    }

    public void setBuildDuration(Long buildDuration) {
        this.buildDuration = buildDuration;
    }

    public String getBuildResult() {
        return buildResult;
    }

    public void setBuildResult(String buildResult) {
        this.buildResult = buildResult;
    }

    public String getBuildUrl() {
        return buildUrl;
    }

    public void setBuildUrl(String buildUrl) {
        this.buildUrl = buildUrl;
    }

    public String getJenkinsUrl() {
        return jenkinsUrl;
    }

    public void setJenkinsUrl(String jenkinsUrl) {
        this.jenkinsUrl = jenkinsUrl;
    }

    public String getExecutorNumber() {
        return executorNumber;
    }

    public void setExecutorNumber(String executorNumber) {
        this.executorNumber = executorNumber;
    }

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getGitCommit() {
        return gitCommit;
    }

    public void setGitCommit(String gitCommit) {
        this.gitCommit = gitCommit;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getGitBranch() {
        return gitBranch;
    }

    public void setGitBranch(String gitBranch) {
        this.gitBranch = gitBranch;
    }

    public String getUpstreamUrl() {
        return upstreamUrl;
    }

    public void setUpstreamUrl(String upstreamUrl) {
        this.upstreamUrl = upstreamUrl;
    }

    public String getUpstreamBuildNumber() {
        return upstreamBuildNumber;
    }

    public void setUpstreamBuildNumber(String upstreamBuildNumber) {
        this.upstreamBuildNumber = upstreamBuildNumber;
    }

    public String getUpstreamProject() {
        return upstreamProject;
    }

    public void setUpstreamProject(String upstreamProject) {
        this.upstreamProject = upstreamProject;
    }

    public boolean isPipeline() {
        return pipeline;
    }

    public void setPipeline(boolean pipeline) {
        this.pipeline = pipeline;
    }

    public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
}
