package edu.unh.cs753;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import edu.unh.cs753.indexing.LuceneSearcher;
import edu.unh.cs753.indexing.LuceneIndexer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.similarities.BM25Similarity;

import co.nstant.in.cbor.CborException;
import edu.unh.cs.treccar_v2.Data;
import edu.unh.cs.treccar_v2.read_data.DeserializeData;
import kotlin.jvm.functions.Function3;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;

public class Main {

	// Main class for project
	public static void main(String[] args) throws IOException {
		System.setProperty("file.encoding", "UTF-8");

		String option = args[0];
		String path = args[1];

		if (option.equals("index")) {
			LuceneIndexer indexer  = new LuceneIndexer("paragraphs"); // The directory that will be made
			indexer.doIndex(path);
		}
		else if (option.equals("search")) {
			System.out.println("here");
			LuceneSearcher searcher = new LuceneSearcher(path);
			searcher.doPowerNapQuery();
			searcher.doWhaleQuery();
			searcher.doPokemonPuzzleLeagueQuery();
		} else if (option.equals("custom")) {

           LuceneSearcher searcher= new LuceneSearcher(path);

           searcher.custom();
			searcher.doPowerNapQuery();
			searcher.doWhaleQuery();
			searcher.doPokemonPuzzleLeagueQuery();

		}



	}

}
