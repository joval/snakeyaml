Default: all

TOP=$(realpath .)
include $(TOP)/../DeveloperTools/install/common.mk

RSRC=rsrc
LIBDIR=$(RSRC)/lib
LIB=$(subst $(SPACE),$(CLN),$(filter %.jar %.zip, $(wildcard $(LIBDIR)/*)))
BUILD=build
SRC=src/main/java
DOCS=docs
CLASSPATH="$(CLASSLIB)$(CLN)$(LIB)$(CLN)$(SRC)"
include classes.mk
CLASS_FILES:=$(foreach class, $(CLASSES), $(BUILD)/$(subst .,/,$(class)).class)
PACKAGES=$(sort $(basename $(CLASSES)))
PACKAGEDIRS=$(subst .,/,$(PACKAGES))
SNAKEYAML=snakeyaml.jar

TEST=test
TESTLIBDIR=$(RSRC)/test
TESTLIB=$(subst $(SPACE),$(CLN),$(filter %.jar %.zip, $(wildcard $(TESTLIBDIR)/*)))
TSRC=src/test/java
JUNIT=$(RSRC)/test/junit-4.12.jar
TESTCP="$(CLASSLIB)$(CLN)$(LIB)$(CLN)$(TESTLIB)$(CLN)$(SNAKEYAML)$(CLN)$(TSRC)"
TESTRUNCP="$(CLASSLIB)$(CLN)$(LIB)$(CLN)$(TESTLIB)$(CLN)$(SNAME_LIB)$(CLN)$(TEST)"
include test_classes.mk
TEST_FILES:=$(foreach class, $(TESTCLASSES), $(TEST)/$(subst .,/,$(class)).class)
TESTPACKAGES=$(sort $(basename $(TESTCLASSES)))
TESTPACKAGEDIRS=$(subst .,/,$(TESTPACKAGES))

CWD=$(shell pwd)

all: $(SNAKEYAML)

$(SNAKEYAML): classes
	$(JAR) cvf $@ -C $(BUILD)/ .

clean:
	rm -f $(SNAKEYAML)
	rm -rf $(BUILD)
	rm -rf $(TEST)

install: all
	cp $(SNAKEYAML) $(TOP)/../jOVAL-Commercial/components/plugin/offline/rsrc/lib

javadocs:
	mkdir -p $(DOCS)
	$(JAVA_HOME)/bin/javadoc -d $(DOCS) -classpath $(CLASSPATH) $(PACKAGES)

classes: classdirs $(CLASS_FILES)

classdirs: $(foreach pkg, $(PACKAGEDIRS), $(BUILD)/$(pkg)/)

$(BUILD)/%.class: $(SRC)/%.java
	$(JAVAC) $(JAVACFLAGS) -d $(BUILD) -classpath $(CLASSPATH) $<

$(BUILD)/%/:
	mkdir -p $(subst PKG,,$@)

test: all test_classes
#	$(foreach class, $(TESTCLASSES), $(JRE) -cp $(TESTRUNCP) org.junit.runner.JUnitCore $(class))

test_classes: test_classdirs $(TEST_FILES)

test_classdirs: $(foreach pkg, $(TESTPACKAGEDIRS), $(TEST)/$(pkg)/)

$(TEST)/%.class: $(TSRC)/%.java
	$(JAVAC) $(JAVACFLAGS) -d $(TEST) -classpath $(TESTCP) $<

$(TEST)/%/:
	mkdir -p $(subst PKG,,$@)

test_classdirs: $(foreach pkg, $(TESTPACKAGEDIRS), $(TEST)/$(pkg)/)
