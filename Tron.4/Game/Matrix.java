package Game;



public class Matrix {
    private int Width, Height;
    private Node Reference, RowIterator, ColumnIterator;
    public Matrix(int Width, int Height) {
        Reference = new Node();
        this.Width = Width; this.Height = Height;
        RowIterator = ColumnIterator = Reference;
        
        for (int I = 0; I < Height; ++I) {
            for (int J = 0; J < Width; ++J) {
                if (I == 0) {
                    if (J < Width - 1) {
                        RowIterator.Right = new Node();
                        RowIterator.Right.Left = RowIterator;
                        RowIterator = RowIterator.Right;
                    }
                }
                else {  
                    if (J < Width - 1) {
                        if (J == 0) {
                            RowIterator.Up = ColumnIterator;
                        }

                        RowIterator.Right = new Node();
                        RowIterator.Up.Down = RowIterator;
                        RowIterator.Right.Left = RowIterator;
                        RowIterator.Right.Up = RowIterator.Up.Right;
                        RowIterator = RowIterator.Right;
                    }
                }
            }
            
            if (I < Height - 1) {
                ColumnIterator.Down = new Node();
                RowIterator = ColumnIterator = ColumnIterator.Down;
            }
        }
    }
    
    
   /**
    * 
    * @param X
    * @param Y
    * @param Value
    * @return
    */
    public int SetValue(int X, int Y, int Value) {
        RowIterator = Reference;
        
        for (int I = 0; I < Y; ++I) {
            RowIterator = RowIterator.Down;
        }
        
        for (int J = 0; J < X; ++J) {
            RowIterator = RowIterator.Right;
        }
        
        RowIterator.Value = Value;
        return 1;
    }
    
    public int GetValue(int X, int Y) {
        RowIterator = Reference;
        
        for (int I = 0; I < Y; ++I) {
            RowIterator = RowIterator.Down;
        }
        
        for (int J = 0; J < X; ++J) {
            RowIterator = RowIterator.Right;
        }
        
        return RowIterator.Value;
    }
    
    public int GetWidth() {
        return Width;
    }
    
    public int GetHeight() {
        return Height;
    }
    
    public void create(){
    	int XM=this.GetWidth();
    	int YM=this.GetHeight();
    	
    	
    	for (int I = 0; I < XM; ++I) {
            for (int J = 0; J < YM; ++J) {
            	if (I==Moto.getXmoto() && J==Moto.getYmoto()){
            		this.SetValue(I, J, 1);
            	}else if(I==10 && J==10) {
            		this.SetValue(I, J, 4);
            	}else{
            		this.SetValue(I, J, 0);
            	}
            }
        }
    	
    }
}
