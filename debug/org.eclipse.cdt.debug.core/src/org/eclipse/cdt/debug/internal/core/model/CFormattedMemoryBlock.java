/*
 *(c) Copyright QNX Software Systems Ltd. 2002.
 * All Rights Reserved.
 * 
 */
package org.eclipse.cdt.debug.internal.core.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.cdt.debug.core.IFormattedMemoryBlock;
import org.eclipse.cdt.debug.core.IFormattedMemoryBlockRow;
import org.eclipse.cdt.debug.core.cdi.CDIException;
import org.eclipse.cdt.debug.core.cdi.model.ICDIMemoryBlock;
import org.eclipse.cdt.debug.internal.core.CDebugUtils;
import org.eclipse.debug.core.DebugException;

/**
 * Enter type comment.
 * 
 * @since: Oct 15, 2002
 */
public class CFormattedMemoryBlock extends CDebugElement implements IFormattedMemoryBlock
{
	class CFormattedMemoryBlockRow implements IFormattedMemoryBlockRow
	{
		private long fAddress;
		private String[] fData;
		private String fAscii;

		/**
		 * Constructor for CFormattedMemoryBlockRow.
		 */
		public CFormattedMemoryBlockRow( long address, String[] data, String ascii )
		{
			fAddress = address;
			fData = data;
			fAscii = ascii;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlockRow#getAddress()
		 */
		public long getAddress()
		{
			return fAddress;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlockRow#getASCII()
		 */
		public String getASCII()
		{
			return fAscii;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlockRow#getData()
		 */
		public String[] getData()
		{
			return fData;
		}
	}

	private String fAddressExpression;
	private ICDIMemoryBlock fCDIMemoryBlock;
	private int fFormat;
	private int fWordSize;
	private int fNumberOfRows;
	private int fNumberOfColumns;
	private boolean fDisplayAscii = true;
	private char fPaddingChar = '.';
	private List fRows = null;

	/**
	 * Constructor for CFormattedMemoryBlock.
	 * @param target
	 */
	public CFormattedMemoryBlock( CDebugTarget target,
								  ICDIMemoryBlock cdiMemoryBlock,
								  String addressExpression,
								  int format,
						  		  int wordSize,
						  		  int numberOfRows,
						  		  int numberOfColumns )
	{
		super( target );
		fCDIMemoryBlock = cdiMemoryBlock;
		fAddressExpression = addressExpression;
		fFormat = format;
		fWordSize = wordSize;
		fNumberOfRows = numberOfRows;
		fNumberOfColumns = numberOfColumns;
		fDisplayAscii = false;
		fPaddingChar = 0;
	}

	/**
	 * Constructor for CFormattedMemoryBlock.
	 * @param target
	 */
	public CFormattedMemoryBlock( CDebugTarget target,
								  ICDIMemoryBlock cdiMemoryBlock,
								  String addressExpression,
								  int format,
						  		  int wordSize,
						  		  int numberOfRows,
						  		  int numberOfColumns,
						  		  char paddingChar )
	{
		super( target );
		fCDIMemoryBlock = cdiMemoryBlock;
		fAddressExpression = addressExpression;
		fFormat = format;
		fWordSize = wordSize;
		fNumberOfRows = numberOfRows;
		fNumberOfColumns = numberOfColumns;
		fDisplayAscii = true;
		fPaddingChar = paddingChar;		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlock#getFormat()
	 */
	public int getFormat()
	{
		return fFormat;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlock#getWordSize()
	 */
	public int getWordSize()
	{
		return fWordSize;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlock#getNumberOfRows()
	 */
	public int getNumberOfRows()
	{
		return fNumberOfRows;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlock#getNumberOfColumns()
	 */
	public int getNumberOfColumns()
	{
		return fNumberOfColumns;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlock#displayASCII()
	 */
	public boolean displayASCII()
	{
		return fDisplayAscii;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlock#getRows()
	 */
	public IFormattedMemoryBlockRow[] getRows()
	{
		if ( fRows == null )
		{
			fRows = new ArrayList();
			try
			{
				int offset = 0;
				byte[] bytes = getBytes();
				while( offset < bytes.length )
				{
					int length = Math.min( fWordSize * fNumberOfColumns, bytes.length - offset );
					fRows.add( new CFormattedMemoryBlockRow( getStartAddress() + offset, 
															 createData( bytes, offset, length ),
															 createAscii( bytes, offset, length ) ) );
					offset += length;
				}
				
			}
			catch( DebugException e )
			{
			}
		}
		return (IFormattedMemoryBlockRow[])fRows.toArray( new IFormattedMemoryBlockRow[fRows.size()] );
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlock#nextRowAddress()
	 */
	public long nextRowAddress()
	{
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlock#previousRowAddress()
	 */
	public long previousRowAddress()
	{
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlock#nextPageAddress()
	 */
	public long nextPageAddress()
	{
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlock#previousPageAddress()
	 */
	public long previousPageAddress()
	{
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlock#reformat(long, int, int, int, int)
	 */
	public void reformat( int format,
						  int wordSize,
						  int numberOfRows,
						  int numberOfColumns ) throws DebugException
	{
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlock#reformat(long, int, int, int, int, char)
	 */
	public void reformat( int format,
						  int wordSize,
						  int numberOfRows,
						  int numberOfColumns,
						  char paddingChar ) throws DebugException
	{
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#getStartAddress()
	 */
	public long getStartAddress()
	{
		if ( fCDIMemoryBlock != null )
		{
			return fCDIMemoryBlock.getStartAddress();
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#getLength()
	 */
	public long getLength()
	{
		if ( fCDIMemoryBlock != null )
		{
			return fCDIMemoryBlock.getLength();
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#getBytes()
	 */
	public byte[] getBytes() throws DebugException
	{
		if ( fCDIMemoryBlock != null )
		{
			try
			{
				return fCDIMemoryBlock.getBytes();
			}
			catch( CDIException e )
			{
				targetRequestFailed( e.getMessage(), null );
			}
		}
		return new byte[0];
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#supportsValueModification()
	 */
	public boolean supportsValueModification()
	{
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#setValue(long, byte[])
	 */
	public void setValue( long offset, byte[] bytes ) throws DebugException
	{
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlock#getPaddingCharacter()
	 */
	public char getPaddingCharacter()
	{
		return fPaddingChar;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlock#dispose()
	 */
	public void dispose()
	{
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.debug.core.IFormattedMemoryBlock#getAddressExpression()
	 */
	public String getAddressExpression()
	{
		return fAddressExpression;
	}
	
	private String[] createData( byte[] bytes, int offset, int length )
	{
		List data = new ArrayList( length / getWordSize() );
		for ( int i = offset; i < offset + length; i += getWordSize() )
		{
			data.add( createDataItem( bytes, i, Math.min( length + offset - i, getWordSize() ) ) );
		}
		return (String[])data.toArray( new String[data.size()] );
	}

	private String createDataItem( byte[] bytes, int offset, int length )
	{
		StringBuffer sb = new StringBuffer( length * 2 );
		for ( int i = offset; i < length + offset; ++i )
		{
			sb.append( CDebugUtils.getByteText( bytes[i] ) );
		}
		return sb.toString();
	}
	
	private String createAscii( byte[] bytes, int offset, int length )
	{
		StringBuffer sb = new StringBuffer( length );
		for ( int i = offset; i < offset + length; ++i )
		{
			sb.append( ( Character.isISOControl( (char)bytes[i] ) || bytes[i] < 0 ) ? getPaddingCharacter() : (char)bytes[i] );
		}
		return sb.toString();
	}
}
