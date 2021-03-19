using System;
using System.Collections.Generic;
using System.Linq;
using Workbench.Comparer;

namespace Workbench.Linq.Extensions
{
    public static class DistinctExtensions
    {
        public static IEnumerable<TEntity> Distinct<TEntity>(this IEnumerable<TEntity> source, Func<TEntity, object> predicate)
        {
            return source.Distinct(GenericComparerFactory<TEntity>.Create(predicate));
        }
    }
}
