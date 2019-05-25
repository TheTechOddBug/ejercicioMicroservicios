stage ('Biblioteca -> Compile') {
        echo "-=- Compiling project -=-"
        bat "mvn clean install -DskipTests"
}

stage ('Biblioteca -> Unit tests') {
        echo "-=- Executing unit tests -=-"
        bat "mvn test"
}

stage ('Biblioteca -> Package') {
        echo "-=- Packaging project -=-"
        bat "mvn package -DskipTests"
}

stage ('Biblioteca -> Deploy') {
        echo "-=- Deploying project -=-"
        echo "Deploying to binaries repository..."
}
