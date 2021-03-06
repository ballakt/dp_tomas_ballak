package cz.zcu.kiv.crce.parser;

import java.io.File;
import cz.zcu.kiv.crce.parser.java.JavaParser;
import cz.zcu.kiv.crce.tools.FileTools;

public class GenericParser implements Parser {

    // provides core functionality of Gen.parser
    private Parser parser;

    /**
     * {@inheritDoc}
     */
    @Override
    public void parse(File file) {
        final String extension = FileTools.getExtension(file);
        preloadParser(extension);
        parser.parse(file);
    }

    /**
     * Loads parser by extension
     * 
     * @param extension - extension of the file: java, cpp, c, etc.
     */
    private void preloadParser(String extension) {
        if (!(parser instanceof JavaParser) && extension == Languages.JAVA.getLanguage()) {
            parser = new JavaParser();
        }
    }

}
