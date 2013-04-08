package org.grobid.core;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.grobid.core.exceptions.GrobidException;
import org.grobid.core.utilities.GrobidProperties;

/**
 * This enum class acts as a registry for all Grobid models. 
 * 
 * @author Patrice Lopez
 */
public enum GrobidModels {
	AFFIILIATON_ADDRESS("affiliation-address"), 
	CITATION("citation"), 
	DATE("date"), 
	EBOOK("ebook"), 
//	ENTITIES_CHEMISTRY("entities/chemistry"), 
//	ENTITIES_BIOTECH("entities/biotech"), 
	FULLTEXT("fulltext"), 
	HEADER("header"), 
	NAMES_CITATION("name/citation"), 
	NAMES_HEADER("name/header"), 
	PATENT_PATENT("patent/patent"), 
	PATENT_NPL("patent/npl"), 
	PATENT_ALL("patent/all"),
	PATENT_STRUCTURE("patent/structure"), 
	PATENT_EDIT("patent/edit"), 
	ENTITIES_CHEMISTRY("chemistry"),
	ENTITIES_NER("ner"),
	ENTITIES_QUANTITIES("quantities"),
	ENTITIES_BIOTECH("bio");
	
	/**
	 * Absolute path to the model.
	 */
	private String modelPath;

	private String folderName;

	GrobidModels(String folderName) {
		this.folderName = folderName;
		File path = GrobidProperties.getModelPath(this);
		if (!path.exists()) {
			// to be reviewed 
			/*System.err.println("Warning: The file path to the "
					+ this.name() + " CRF model is invalid: "
					+ path.getAbsolutePath());*/
		}
		modelPath=path.getAbsolutePath();
	}

	public String getFolderName() {
		return folderName;
	}
	
	public String getModelPath(){
		return modelPath;
	}

	public String getModelName() {
		return folderName.replaceAll("/", "-");
	}

	public String getTemplateName() {
		return StringUtils.substringBefore(folderName, "/") + ".template";
	}

	@Override
	public String toString() {
		return folderName;
	}
}
