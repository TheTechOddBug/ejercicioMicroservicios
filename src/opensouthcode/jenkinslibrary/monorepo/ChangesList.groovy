package opensouthcode.jenkinslibrary.monorepo

class ChangesList implements Serializable {
    def changes = []
    ChangesList () { }
    def getListOfChangesSoloPath(currentBuild){
        def build = currentBuild
        while (build != null && build.result != 'SUCCESS') {
            for (changeLog in build.changeSets) {
                for (entry in changeLog.items) {
                    for (file in entry.affectedFiles) {
                        if (file.path.lastIndexOf('/') != -1) {
                            def soloPath = file.path.substring(0, file.path.lastIndexOf('/'))
                            changes << soloPath
                        }
                    }
                }
            }
            build = build.previousBuild
        }
        changes = changes.unique()
        return changes
    }
}
