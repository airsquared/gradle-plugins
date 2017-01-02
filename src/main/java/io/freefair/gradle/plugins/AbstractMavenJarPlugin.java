package io.freefair.gradle.plugins;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.tasks.bundling.Jar;

/**
 * @author Lars Grefer
 */
@Getter
abstract class AbstractMavenJarPlugin extends AbstractPlugin {

    private Jar jarTask;

    @Override
    public void apply(Project project) {
        super.apply(project);
        jarTask = project.getTasks().create(getTaskName(), Jar.class);
        jarTask.setClassifier(getClassifier());

        project.getArtifacts().add(Dependency.ARCHIVES_CONFIGURATION, getJarTask());
    }

    protected abstract String getClassifier();

    protected String getTaskName() {
        return getClassifier() + "Jar";
    }
}
