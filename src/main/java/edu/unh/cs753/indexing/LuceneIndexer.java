package edu.unh.cs753.indexing;

import edu.unh.cs753.utils.IndexUtils;
import org.apache.lucene.index.IndexWriter;

public class LuceneIndexer {
    private final IndexWriter writer;
    private final string myString;
    LuceneIndexer(String indexLoc) {
        writer = IndexUtils.createIndexWriter(indexLoc);
    }



}
