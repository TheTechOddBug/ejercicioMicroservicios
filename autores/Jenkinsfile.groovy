stage ('Autores -> Compile') {
        echo "-=- Compiling project -=-"
        bat "mvn clean install -DskipTests"
}

stage ('Autores -> Unit tests') {
        echo "-=- Executing unit tests -=-"
        bat "mvn test"
}

stage ('Autores -> Package') {
        echo "-=- Packaging project -=-"
        bat "mvn package -DskipTests"
}

stage ('Autores -> Deploy') {
        echo "-=- Deploying project -=-"
        echo "Deploying to binaries repository..."
}
