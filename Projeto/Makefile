######### MAKEFILE #########

JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		Registrador.java	\
		Operacoes.java	\
		Maquina.java	\
		Main.java

all: classes
	@echo "Build Pronta"

classes: $(CLASSES:.java=.class)

run:
	java Main

###### CLEAN #####
clean:	
		rm -rf *.class
		@echo "clean"

