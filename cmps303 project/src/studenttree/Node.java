package studenttree;

import java.io.Serializable;

class Node implements Serializable
   {
   public int iData;              // data item (key)
   public Student sData;           // data item
   public Node leftChild;         // this node's left child
   public Node rightChild;        // this node's right child

   public void displayNode()      // display ourself
      {
      System.out.print('{');
      System.out.print(iData);
      System.out.print(", ");
      System.out.print(sData);
      System.out.print("} ");
      }
   
   public Student getStudent()
   {
	   return sData;
   }
   }  // end class Node