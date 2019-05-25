#!/usr/bin/groovy

import opensouthcode.jenkinslibrary.monorepo.ChangesList
import opensouthcode.jenkinslibrary.monorepo.AppIdentification

def call(){
    echo "-=- Starting identification of changes and sorting applications -=-"
    changes = new ChangesList().getListOfChangesSoloPath(currentBuild)
    sortedAppsDependencies = globalVariables.sortedAppDependencyList()
    sortedChanges = new AppIdentification().getSortedChangesList(sortedAppsDependencies, changes)
    script {
        sortedChanges.each {
            echo "it::" + it
            dir (it) {
                def appPipeline = fileLoader.load("Jenkinsfile")
            }
        }
    }
}
