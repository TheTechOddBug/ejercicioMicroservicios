package opensouthcode.jenkinslibrary.monorepo

class AppIdentification implements Serializable {
    def sortedChangesList = []
    AppIdentification () { }
    def getSortedChangesList(appList, changesList){
        appList.each {
            if (changesList.size() > 0) {
                for (item in changesList){
                    if(item.contains(it)){
                        sortedChangesList << it
                        break
                    }
                }
            }
        }
        return sortedChangesList
    }
}
