# codechallenge
# 
# 
## Java
###### # brew tap caskroom/versions
###### # brew cask install java7
# 
# 
## Maven
###### #brew install maven
# 
# 
## Eclipse
###### # brew cask install eclipse-ide
Depois de instalar o Eclipse acessar o Marketplace e instalar JBOSS TOOLS e STS (Help > Eclipse Marketplace)
# 
##  NodeJS
###### # brew install node
# 
# 
## Yeoman + Bower + Grunt + Gulp + generator + angular generator
###### # npm install -g yo bower grunt-cli gulp
###### # npm install -g generator-webapp
###### # npm install -g generator-angular
# 
# 
## Clonar projeto
###### # git clone https://github.com/rodrigoagostin/codechallenge
# 
# 
##### Agora vamos configurar o ambiente Java.
* Abrir eclipse
* File > Import > Maven > Existing Maven Projects
* Clique em Project > Clean > Selecione Clean projects selected bellow > Selecione CodeChallenge > Ok
* Clique com botão direito sobre o projeto importado, siga até Maven e clique em Update Project, selecione Force Update... e clique em Ok

Para rodar o projeto clique com o botão direito sobre o projeto importanto
* Run As > Spring Boot App
* Caso está opção não apareça, clicar em Help > Eclipse Marketplace > buscar por STS

##### Agora vamos configurar o ambiente node
###### # npm install
###### # bower install
###### # grunt serve
# 
###E pronto!

