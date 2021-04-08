using System.Collections.Generic;

namespace dotnet_poo.Interfaces
{
    public interface IRepository<T>
    {
        List<T> GetAll();
        T GetById(int id);
        void Insert(T entity);
        int NextId();
        void Remove(int id);
        void Update(int id, T entity);
    }
}