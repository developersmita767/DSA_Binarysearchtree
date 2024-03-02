import java.util.Scanner;
class  node
{
	node left;
	int data;
	node right;	
}
class binarysearchtree
{
	static Scanner sc=new Scanner(System.in);
	static node insert(node root,int data)
	{
		if(root==null)
		{
			return newnode(data);
		}
		if(data<root.data)
		{
			root.left=insert(root.left,data);
				
		}
		if(data>root.data)
		{
			root.right=insert(root.right,data);
		}

		return root;
	}
	static node newnode(int data)
	{
		node p=new node();
		p.data=data;
		p.left=null;
		p.right=null;
		return p;
	}
	static void preorder(node root)
	{
		if(root!=null)
		{
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	static void inorder(node root)
	{
		if(root!=null)
		{
			
			preorder(root.left);
			System.out.println(root.data);
			preorder(root.right);
		}
	}
	static void postorder(node root)
	{
		if(root!=null)
		{
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.data);
		}
	}
	static void delete(node root,int ele)
	{
		 boolean found=false;
		node curr=null,parent=null;
		curr=root;
	while(curr!=null)
   {
		  if(curr.data==ele)
		   {
			  found=true;
			  break;
		   }
		  else
		   {
			   parent=curr;
			 if(ele>curr.data)
			  {
				curr=curr.right;
			  }
			 else
			  {
				 curr=curr.left;
			  }
			}
     }
    if(!found)
    {
      System.out.println("Element Not Found");
       return;
    }
	// leaf node delete
	if(curr.right==null && curr.left==null)
    {
       if(curr==parent.right)
        {
          parent.right=null;
        }
        else
        {
           parent.left=null;
        }
       
     }
     //internal node one element  delete
	else if(curr.left==null && curr.right!=null ||  curr.left!=null && curr.right==null)
    {
       if(curr.left==null)
        {
           if(parent.right==curr)
            {
               parent.right=curr.right;
            }
           else 
            {
               parent.left=curr.right;
            }
           curr.right=null;
    
         }
       else
         {
            if(parent.right==curr)
             {  
                parent.right=curr.left;
             }
            else
             {
                parent.left=curr.left;
             }
          curr.left=null;
          
          }
       }

   //2 child node delete
	else
     {     
	        node t1=null,t2=null;
	       t1=curr.right;
        if(t1.right==null && t1.left==null)
	    {
           curr.data=t1.data;
           curr.right=null;
           
	    }
	    else if(t1.right!=null && t1.left==null)
	    {
	    	curr.data=t1.data;
	    	curr.right=t1.right;
	    	t1.right=null;
	    }
	    else if(t1.left!=null)
	    {
	    	t2=t1.left;
	    	while(t2.left!=null)
	    	{
	    		t1=t1.left;
	    		t2=t2.left;
	    	}
	     curr.data=t2.data;
	      t1.left=t2.right;
	      t2.right=null;
	      
	    }


	}
}
}
class Test
{
	public static void main(String arg[])
	{
		node root=null;
		root=binarysearchtree.insert(root,10);
		root=binarysearchtree.insert(root,5);
		root=binarysearchtree.insert(root,15);
		root=binarysearchtree.insert(root,7);
		root=binarysearchtree.insert(root,6);
		root=binarysearchtree.insert(root,3);
		root=binarysearchtree.insert(root,12);
		root=binarysearchtree.insert(root,11);
		binarysearchtree.preorder(root);
		binarysearchtree.delete(root,15);
		binarysearchtree.delete(root,12);
		binarysearchtree.preorder(root);

	}
}