stage ('Libros -> Compile') {
        echo "-=- Compiling project -=-"
        bat "mvn clean install -DskipTests"
}

stage ('Libros -> Unit tests') {
        echo "-=- Executing unit tests -=-"
        bat "mvn test"
}

stage ('Libros -> Package') {
        echo "-=- Packaging project -=-"
        bat "mvn package -DskipTests"
}

stage ('Libros -> Deploy') {
        echo "-=- Deploying project -=-"
        echo "Deploying to binaries repository..."
}
