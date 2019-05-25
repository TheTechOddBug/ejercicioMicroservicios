stage ('Editoriales -> Compile') {
        echo "-=- Compiling project -=-"
        bat "mvn clean install -DskipTests"
}

stage ('Editoriales -> Unit tests') {
        echo "-=- Executing unit tests -=-"
        bat "mvn test"
}

stage ('Editoriales -> Package') {
        echo "-=- Packaging project -=-"
        bat "mvn package -DskipTests"
}

stage ('Editoriales -> Deploy') {
        echo "-=- Deploying project -=-"
        echo "Deploying to binaries repository..."
}
