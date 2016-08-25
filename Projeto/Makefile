######### MAKEFILE #########

JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		Registrador.java	\
		LanguageProcessor.java 	\
		AssemblyMachine.java	\
		FormMain.java

all: classes
	@echo "Build Pronta"

classes: $(CLASSES:.java=.class)

run:
	java FormMain

###### CLEAN #####
clean:	
		rm -rf *.class
		@echo "clean"

