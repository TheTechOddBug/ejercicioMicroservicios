stage ('Ejercicio-dto -> Compile') {
        echo "-=- Compiling project -=-"
        bat "mvn clean install -DskipTests"
}

stage ('Ejercicio-dto -> Unit tests') {
        echo "-=- Executing unit tests -=-"
        bat "mvn test"
}

stage ('Ejercicio-dto -> Package') {
        echo "-=- Packaging project -=-"
        bat "mvn package -DskipTests"
}

stage ('Ejercicio-dto -> Deploy') {
        echo "-=- Deploying project -=-"
        echo "Deploying to binaries repository..."
}
