/**
  * private[x],表示这个成员除了对[x]中的类或包中的类及它们的伴生对象可见外，对其它所有类都是private。
  */
package bobsrocckets {

  package navigation {
    private[bobsrocckets] class Navigator {
      protected[navigation] def useStarChart() {}

      class LegOfJourney {
        private[Navigator] val distance = 100;
      }

      private[this] val speed = 200;
    }
  }

  package lanuch {
    import bobsrocckets.navigation._;

    object Vechicle{
      private[lanuch] val guide = new Navigator;
    }
  }
}
