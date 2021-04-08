using System.Collections.Generic;
using dotnet_poo.Interfaces;

namespace dotnet_poo.Classes
{
    public class SerieRepository : IRepository<Serie>
    {
        private List<Serie> listSeries = new List<Serie>();

        public List<Serie> GetAll()
        {
            return this.listSeries;
        }

        public Serie GetById(int id)
        {
            return this.listSeries[id];
        }

        public void Insert(Serie serie)
        {
            this.listSeries.Add(serie);
        }

        public int NextId()
        {
            return this.listSeries.Count;
        }

        public void Remove(int id)
        {
            this.listSeries[id].Delete();
        }

        public void Update(int id, Serie serie)
        {
            this.listSeries[id] = serie;
        }
    }
}