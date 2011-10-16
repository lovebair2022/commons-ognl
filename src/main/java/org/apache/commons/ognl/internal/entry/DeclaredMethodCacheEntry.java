package org.apache.commons.ognl.internal.entry;

/**
 * User: Maurizio Cucchiara
 * Date: 10/15/11
 * Time: 9:02 AM
 */
public class DeclaredMethodCacheEntry
    extends MethodCacheEntry
{

    MethodType type;

    public enum MethodType
    {
        STATIC, NON_STATIC
    }

    public DeclaredMethodCacheEntry( Class<?> targetClass )
    {
        super( targetClass );
    }

    public DeclaredMethodCacheEntry( Class<?> targetClass, MethodType type)
    {
        super( targetClass );
        this.type = type;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( !( o instanceof DeclaredMethodCacheEntry ) )
        {
            return false;
        }

        DeclaredMethodCacheEntry that = (DeclaredMethodCacheEntry) o;

        if ( type != that.type )
        {
            return false;
        }
        if ( targetClass != that.targetClass )
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode( )
    {
        int result = targetClass.hashCode( );
        if(type!=null)
            result = 31 * result + type.hashCode();
        return result;
    }
}