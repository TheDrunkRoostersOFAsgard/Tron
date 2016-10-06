
public class Matrix {
    private int Width, Height;
    private Node Reference, RowIterator, ColumnIterator;
    private Moto moto=new Moto(2,2);
    private Items Items;
    
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
    
    public void SetValue(int X, int Y, int Value) {
        RowIterator = Reference;
        
        for (int I = 0; I < Y; ++I) {
            RowIterator = RowIterator.Down;
        }
        
        for (int J = 0; J < X; ++J) {
            RowIterator = RowIterator.Right;
        }
        
        RowIterator.Value = Value;
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
            	if (I==moto.getXmoto() && J==moto.getYmoto()){
            		this.SetValue(I, J, 1);
            	}else if (I==Items.getX() && J==Items.getY()){
            		this.SetValue(I, J, 2);
            	}else{
            		this.SetValue(I, J, 0);
            	}
            }
        }
    	
    	 for (int I = 0; I < this.GetHeight()-1; ++I) {
             for (int J = 0; J < this.GetWidth(); ++J) {
                 System.out.print(this.GetValue(J, I) + "  ");    
             }
             System.out.println();
         }
    }
}
