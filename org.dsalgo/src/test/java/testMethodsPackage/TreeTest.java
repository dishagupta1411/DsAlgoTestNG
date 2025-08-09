package testMethodsPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import driverFactory.DriverFactory;
import pageObjects.BasePage;
import pageObjects.TreePage;
import utils.LoggerLoad;

public class TreeTest extends BaseTest{
	
	TreePage treePg;
	BasePage basePg;
    DriverFactory driverfact;
    LoggerLoad log;
	
	@BeforeMethod
	public void graphPage() throws InterruptedException, IOException {
		basePg = new BasePage();
		treePg = new TreePage();
		log = new LoggerLoad();
	}
	
	
	
	@Test
	public void verifyTreeLinks() throws InterruptedException, IOException {
		treePg.getToTree();
		treePg.verifyLinks();
	}
	@Test
	public void clickOverview() throws InterruptedException, IOException {		
		log.info("Navigating the Overview Tree Page");
		treePg.getToTree();
		treePg.click_Overview();
		String actualTitle = basePg.getTitle();
		String expectedTitle= "Overview of Trees";
		treePg.click_TryHere();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test
	public void clickTerminology() throws InterruptedException, IOException {
		log.info("Navigating the Terminilogy Tree Page");
		treePg.getToTree();
		treePg.click_Terminilogy();
		String actualTitle = basePg.getTitle();
		String expectedTitle= "Terminologies";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test
	public void typesTree() throws InterruptedException, IOException {
		log.info("Navigating the Types of Tree Page");
		treePg.getToTree();
		treePg.typesOfTrees();
		String actualTitle = basePg.getTitle();
		String expectedTitle= "Types of Trees";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
		public void tree_Traversals() throws InterruptedException, IOException {
			log.info("Navigating the Tree Traversals");
			treePg.getToTree();
			treePg.tree_Trav();
			String actualTitle = basePg.getTitle();
			String expectedTitle= "Tree Traversals";
			Assert.assertEquals(actualTitle, expectedTitle);
		}

	
	@Test
	public void Traversals_Illus() throws InterruptedException, IOException {
		log.info("Navigating the Tree traversals-illustration");
		treePg.getToTree();
		treePg.Traversal_Illustra();
		String actualTitle = basePg.getTitle();
		String expectedTitle= "Traversals-Illustration";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	
	@Test
	public void binary_Tree() throws InterruptedException, IOException {
		log.info("Navigating the Binary Tree");
		treePg.getToTree();
		treePg.binary_Tree();
		String actualTitle = basePg.getTitle();
		String expectedTitle= "Binary Trees";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void types_OfBinaryTree() throws InterruptedException, IOException {
		log.info("Navigating the Types of Binary Tree");
		treePg.getToTree();
		treePg.types_ofBinary();
		String actualTitle = basePg.getTitle();
		String expectedTitle= "Types of Binary Trees";
		Assert.assertEquals(actualTitle, expectedTitle);
	}


	@Test
	public void implement_OfPython() throws InterruptedException, IOException {
		log.info("Naviagating to Implementation of Python");
		treePg.getToTree();
		treePg.Impl_in_Python();
		String actualTitle = basePg.getTitle();
		String expectedTitle= "Implementation in Python";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void binaryTreTraver() throws InterruptedException, IOException {
		log.info("Naviagating to Binary Tree Traversals");
		treePg.getToTree();
		treePg.binary_Tree_Travers();	
		String actualTitle = basePg.getTitle();
		String expectedTitle= "Binary Tree Traversals";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	
	@Test
	public void impl_OfBinaryTrees() throws InterruptedException, IOException {
		log.info("Naviagating to Implementation of Binary Trees");
		treePg.getToTree();
		treePg.binary_Tree_Travers();	
		String actualTitle = basePg.getTitle();
		String expectedTitle= "Implementation of Binary Trees";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	@Test
	public void appBinaryTree() throws InterruptedException, IOException {
		log.info("Naviagating to Applications of Binary trees");
		treePg.getToTree();
		treePg.app_of_binaryTrees();	
		String actualTitle = basePg.getTitle();
		String expectedTitle= "Applications of Binary trees";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void binarySearch() throws InterruptedException, IOException {
		log.info("Naviagating to Binary Search Trees");
		treePg.getToTree();
		treePg.binary_Search();	
		String actualTitle = basePg.getTitle();
		String expectedTitle= "Binary Search Trees";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	@Test
	public void impOfBst() throws InterruptedException, IOException {
		log.info("Naviagating to Implementation Of BST");
		treePg.getToTree();
		treePg.Implement_OfBst();	
		String actualTitle = basePg.getTitle();
		String expectedTitle= "Implementation Of BST";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
}
